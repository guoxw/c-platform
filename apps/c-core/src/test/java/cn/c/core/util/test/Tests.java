package cn.c.core.util.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import cn.c.core.domain.Task;
import cn.c.core.dto.TaskDto;
import cn.c.core.util.EntityUtils;



public class Tests {

	@Test
	public void test001() {
		Task parent = new Task();
		parent.setCode("patentCode");
		parent.setName("parentName");
		
		Task parent1 = new Task();
		parent.setCode("patentCode1");
		parent.setName("parentName1");

		Task t = new Task();
		t.setCode("code1");
		t.setName("name1");
		t.setParent(parent);
		t.setParent1(parent1);
		t.setType(1);
		t.setDate(new Date());
		t.setDelete(true);
		t.setDtoNotExist("iiii");
		t.setCreateTime(new Date());

		TaskDto tt = EntityUtils.copy(TaskDto.class, t);
		Assert.assertEquals(t.getCode(), tt.getCode());
		Assert.assertEquals(t.getName(), tt.getName());
		Assert.assertEquals(t.getType(), tt.getType());
		Assert.assertEquals(t.getDate(), tt.getDate());
		Assert.assertEquals(t.isDelete(), tt.isDelete());
		Assert.assertNull(tt.getDomainNotExist());
		Assert.assertEquals(t.getCreateUserCode(), tt.getCreateUserCode());
		Assert.assertEquals(t.getCreateTime(), tt.getCreateTime());
		Assert.assertNotNull(tt.getParent());
		Assert.assertEquals(t.getParent().getCode(), tt.getParent().getCode());
		Assert.assertEquals(t.getParent().getName(), tt.getParent().getName());
		
		Assert.assertTrue(EntityUtils.containsMethod(TaskDto.class, "getCode"));

	}
	
	@Test(expected=cn.c.core.excepion.NoSuchMethodException.class)
	public void test002() {
		Task parent = new Task();
		//EntityUtils.getGeterMethod(parent.getClass(), "abc", true);
		EntityUtils.getSeterMethod(parent.getClass(), "abc", true);
	}

	

}
