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
import com.aspire.dao.LevelThreeDao;
import com.aspire.entity.LevelThree;

/**
 * 测试levelTwoDao
 * @author 丁丁
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRun.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  
public class LevelThreeDaoTest {
    @Resource
    LevelThreeDao levelThreeDao;
	
    // 记录测试的ID
    static Integer testId;
    
    // 增加
	@Test
	public void a_addlevelThreeTitleTest(){
		LevelThree levelThree=new LevelThree();
		levelThree.setTitleTwoId(1);
		levelThree.setTitleName("测试名字");
		levelThree.setCreateTime(new Date());
		levelThree.setLastModifyTime(new Date());
		int addlevelThree=levelThreeDao.addLevelThreeTitle(levelThree);
		assertEquals(1, addlevelThree);
	}
    
	// 查询全部
	@Test
	public void b_finAllTest(){
		List<LevelThree> levelThreeList=levelThreeDao.findAll();
		assertNotNull("值不存在", levelThreeList);
		testId = levelThreeList.get(levelThreeList.size()-1).getTitleThreeId();
	}
	
	// 根据二级标题查询
	@Test
	public void c_findTitleBylevelTwoIdTest(){
		List<LevelThree> levelThreeList=levelThreeDao.findTitleByLevelTwoId(1);
		assertNotNull("值不存在", levelThreeList);
	}
	
	// 根据三级标题查询
	@Test
	public void d_findTitleBylevelThreeIdTest(){
		LevelThree levelThree=levelThreeDao.findTitleByLevelThreeId(testId);
		assertNotNull("值不存在", levelThree);
	}
	
	// 更新标题
	@Test
	public void e_updateTitleTest(){
		LevelThree levelThree=new LevelThree();
		levelThree.setTitleThreeId(testId);
		levelThree.setTitleTwoId(1);
		levelThree.setTitleName("测试名字0");
		levelThree.setCreateTime(new Date());
		levelThree.setLastModifyTime(new Date());
		int updateTitle=levelThreeDao.updateTitle(levelThree);
		assertEquals(1, updateTitle);
	}
	
	// 删除三级标题
	@Test
	public void f_removelevelThreeTitle(){
		int removelevelThree=levelThreeDao.removeLevelThreeTitle(testId);
		assertEquals(1, removelevelThree);
	}
}
