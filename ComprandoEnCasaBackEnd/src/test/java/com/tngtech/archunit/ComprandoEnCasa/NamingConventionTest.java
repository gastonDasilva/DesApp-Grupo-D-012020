package com.tngtech.archunit.ComprandoEnCasa;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService.MyController;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service.MyService;
import org.junit.runner.RunWith;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchUnitRunner;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.ComprandoEnCasa.ComprandoEnCasaBackEnd")
public class NamingConventionTest {

    @ArchTest
    public static ArchRule services_should_be_prefixed =
            classes()
                    .that().resideInAPackage("..Service..")
                    .and().areAnnotatedWith(MyService.class)
                    .should().haveSimpleNameContaining("Service");

    @ArchTest
    public static ArchRule controllers_should_not_have_Gui_in_name =
            classes()
                    .that().resideInAPackage("..WebService..")
                    .should().haveSimpleNameNotContaining("Gui");


    @ArchTest
    public static ArchRule controllers_should_be_suffixed =
            classes()
                    .that().resideInAPackage("..WebService..")
                    .or().areAnnotatedWith(MyController.class)
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    public static ArchRule classes_named_controller_should_be_in_a_WebService_package =
            classes()
                    .that().haveSimpleNameContaining("Controller")
                    .should().resideInAPackage("..WebService..");


    @ArchTest
    public static ArchRule classes_named_repository_should_be_in_a_Repositories_package =
            classes()
                    .that().haveSimpleNameContaining("Repository")
                    .should().resideInAPackage("..Repositories..");
}
