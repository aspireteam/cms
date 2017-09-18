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
import com.aspire.dao.LevelOneDao;
import com.aspire.entity.LevelOne;

/**
 * 测试LevelOneDao
 * @author 丁丁
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRun.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  
public class LevelOneDaoTest {
    @Resource
    LevelOneDao levelOneDao;
	
    // 记录测试的ID
    static Integer testId;
    
    // 增加
	@Test
	public void a_addLevelOneTitleTest(){
		LevelOne levelOne=new LevelOne();
		levelOne.setTitleName("测试名字2");
		levelOne.setCreateTime(new Date());
		levelOne.setLastModifyTime(new Date());
		int addLevelOne=levelOneDao.addLevelOneTitle(levelOne);
		assertEquals(1, addLevelOne);
	}
	
    // 查询全部
	@Test
	public void b_finAllTest(){
		List<LevelOne> levelOneList=levelOneDao.findAll();
		assertNotNull("值不存在", levelOneList);
		testId = levelOneList.get(levelOneList.size()-1).getTitleOneId();
	}
	
	// 根据一级标题查询
	@Test
	public void c_findTitleByLevelOneIdTest(){
		LevelOne levelOne=levelOneDao.findTitleByLevelOneId(testId);
		assertNotNull("值不存在", levelOne);
	}
	
	// 更新标题
	@Test
	public void d_updateTitleTest(){
		LevelOne levelOne=new LevelOne();
		levelOne.setTitleOneId(testId);
		levelOne.setTitleName("测试名字0");
		levelOne.setCreateTime(new Date());
		levelOne.setLastModifyTime(new Date());
		int updateTitle=levelOneDao.updateTitle(levelOne);
		assertEquals(1, updateTitle);
	}
	
	// 删除标题
	@Test
	public void e_removeLevelOneTitle(){
		int removeLevelOne=levelOneDao.removeLevelOneTitle(testId);
		assertEquals(1, removeLevelOne);
	}
}
