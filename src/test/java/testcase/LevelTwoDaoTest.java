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
import com.aspire.dao.LevelTwoDao;
import com.aspire.entity.LevelTwo;

/**
 * 测试levelTwoDao
 * @author 丁丁
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRun.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  
public class LevelTwoDaoTest {
    @Resource
    LevelTwoDao levelTwoDao;
	
    // 记录测试的ID
    static Integer testId;
    
    // 增加
	@Test
	public void a_addlevelTwoTitleTest(){
		LevelTwo levelTwo=new LevelTwo();
		levelTwo.setTitleOneId(1);
		levelTwo.setTitleName("测试名字2");
		levelTwo.setCreateTime(new Date());
		levelTwo.setLastModifyTime(new Date());
		int addlevelTwo=levelTwoDao.addLevelTwoTitle(levelTwo);
		assertEquals(1, addlevelTwo);
	}
    
	// 查询全部
	@Test
	public void b_finAllTest(){
		List<LevelTwo> levelTwoList=levelTwoDao.findAll();
		assertNotNull("值不存在", levelTwoList);
		testId = levelTwoList.get(levelTwoList.size()-1).getTitleTwoId();
	}
	
	// 根据一级标题查询
	@Test
	public void c_findTitleBylevelOneIdTest(){
		List<LevelTwo> levelTwoList=levelTwoDao.findTitleByLevelOneId(testId);
		assertNotNull("值不存在", levelTwoList);
	}
	
	// 根据二级标题查询
	@Test
	public void d_findTitleBylevelTwoIdTest(){
		LevelTwo levelTwo=levelTwoDao.findTitleByLevelTwoId(testId);
		assertNotNull("值不存在", levelTwo);
	}
	
	// 更新标题
	@Test
	public void e_updateTitleTest(){
		LevelTwo levelTwo=new LevelTwo();
		levelTwo.setTitleTwoId(1);
		levelTwo.setTitleOneId(1);
		levelTwo.setTitleName("测试名字0");
		levelTwo.setCreateTime(new Date());
		levelTwo.setLastModifyTime(new Date());
		int updateTitle=levelTwoDao.updateTitle(levelTwo);
		assertEquals(1, updateTitle);
	}
	
	// 删除二级标题
	@Test
	public void f_removelevelTwoTitle(){
		int removelevelTwo=levelTwoDao.removeLevelTwoTitle(testId);
		assertEquals(1, removelevelTwo);
	}
}
