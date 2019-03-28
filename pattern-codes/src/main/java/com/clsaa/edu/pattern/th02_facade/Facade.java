package com.clsaa.edu.pattern.th02_facade;

import com.clsaa.edu.pattern.th02_facade.th01_counter_example.Business;
import com.clsaa.edu.pattern.th02_facade.th01_counter_example.Dao;
import com.clsaa.edu.pattern.th02_facade.th01_counter_example.Presentation;

public class Facade {
    public void generate() {
        new Business().generate();
        new Dao().generate();
        new Presentation().generate();
    }
}
