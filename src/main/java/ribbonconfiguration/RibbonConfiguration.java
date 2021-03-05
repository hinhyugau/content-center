package ribbonconfiguration;

import com.itmuch.contentcenter.config.NacosSameMetaDataWrigthRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/2 2:13 下午
 * @Version 1.0
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new NacosSameMetaDataWrigthRule();
    }
}
