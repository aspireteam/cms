package testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aspire.ApplicationRun;
import com.aspire.dao.ContentDao;
import com.aspire.entity.Content;

/**
 * 测试levelTwoDao
 * 
 * @author 丁丁
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRun.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContentDaoTest {
	@Resource
	ContentDao contentDao;

	// 记录测试的ID
	static Integer testId;

	// 增加
	@Test
	public void a_addBody() {
		Content content = new Content();
		content.setTitleThreeId(1);
		content.setBody("测试内容");
		content.setCreateTime(new Date());
		content.setLastModifyTime(new Date());
		int addContent = contentDao.addBody(content);
		assertEquals(1, addContent);
	}

	// 查询全部
	@Test
	public void b_finAllTest() {
		List<Content> contentList = contentDao.findAll();
		assertNotNull("值不存在", contentList);
		testId = contentList.get(contentList.size() - 1).getContentId();
	}

	// 根据三级级标题查询
	@Test
	public void c_findBodyByLevelThreeIdTest() {
		Content content = contentDao.findBodyByLevelThreeId(1);
		System.out.println(content.getBody());
		assertNotNull("值不存在", content);
	}

	// 根据内容模糊查询全部符合的主体内容
	@Test
	public void c_findBodyBySearchTest() {
		List<Content> contentList = contentDao.findBodyBySearch("容");
		System.err.println(contentList.size());
	}

	// 根据主体内容Id查询主体内容
	@Test
	public void d_findBodyByContentIdTest() {
		Content levelThree = contentDao.findBodyByContentId(testId);
		assertNotNull("值不存在", levelThree);
	}

	// 更新标题
	@Test
	public void e_updateBody() {
		Content content = new Content();
		content.setContentId(testId);
		content.setTitleThreeId(1);
		content.setBody("测试内容");
		content.setCreateTime(new Date());
		content.setLastModifyTime(new Date());
		int updateBody = contentDao.updateBody(content);
		assertEquals(1, updateBody);
	}

	// 删除三级标题
	@Test
	public void f_removeBody() {
		int removeBody = contentDao.removeBody(testId);
		assertEquals(1, removeBody);
	}
}
