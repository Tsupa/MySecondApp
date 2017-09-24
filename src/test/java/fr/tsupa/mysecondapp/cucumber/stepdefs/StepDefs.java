package fr.tsupa.mysecondapp.cucumber.stepdefs;

import fr.tsupa.mysecondapp.MySecondApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = MySecondApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
