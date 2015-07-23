package com.zhernakov;

import com.zhernakov.samples.security.config.RootConfig;
import com.zhernakov.samples.security.model.Dict;
import com.zhernakov.samples.security.model.DictElem;
import com.zhernakov.samples.security.service.DictElemService;
import com.zhernakov.samples.security.service.DictService;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Objects;

/**
 * Created by Misha on 22.07.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class})
public class TestApp {

    @Autowired
    WebApplicationContext wac;
    @Autowired
    DictService<Dict> dictService;
    @Autowired
    DictElemService<DictElem> dictElemService;

    @Autowired
    FilterChainProxy filterChainProxy;

    MockMvc mockMvc;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilter(filterChainProxy) // добавляем фильтр безопасности
                .dispatchOptions(true).build();

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ADMIN");
        Authentication auth = new UsernamePasswordAuthenticationToken("admin", "q", authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Test
    public void testData() {
        final Dict dict1 = createDict("Справочник 1");
        dictElemService.add(new DictElem("Элемент 1", dict1.getId()));
    }

    private Dict createDict(String name) {
        final Dict dict = new Dict(name);
        Assert.isTrue(dictService.add(dict));
        Assert.notNull(dict.getId());
        Assert.isTrue(!Objects.equals(dict.getId(), NumberUtils.LONG_ZERO));
        return dict;
    }
}
