import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.cust.bean.User;
import com.offcn.cust.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Test1 {

    @Test
    public void getGoodsList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserMapper mapper = context.getBean(UserMapper.class);

        PageHelper.startPage(1,5);
        List<User> goodsList = mapper.getGoodsList();

        PageInfo<User> page = new PageInfo(goodsList,10);

        System.out.println("总页数："+page.getPages());
        System.out.println("总记录数："+page.getTotal());

        System.out.println("当前页："+page.getPageNum());

        System.out.println("上一页："+page.getPrePage());
        System.out.println("下一页："+page.getNextPage());

        System.out.println("是否有上一页："+page.isHasPreviousPage());
        System.out.println("是否有下一页："+page.isHasNextPage());


        System.out.println("是否为首页："+page.isIsFirstPage());
        System.out.println("是否为末页："+page.isIsLastPage());


        System.out.println("PageSize："+page.getPageSize());
        List<User> list = page.getList();
        for (User goods : list) {
            System.out.println(goods);
        }

        int[] nums = page.getNavigatepageNums();

        System.out.println(Arrays.toString(nums));

    }
}
