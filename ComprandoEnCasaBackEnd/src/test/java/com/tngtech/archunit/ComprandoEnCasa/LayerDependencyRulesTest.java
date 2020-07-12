package com.tngtech.archunit.ComprandoEnCasa;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.ComprandoEnCasa.ComprandoEnCasaBackEnd")
public class LayerDependencyRulesTest {

    @ArchTest
    public static final ArchRule services_should_not_access_controllers =
            noClasses().that().resideInAPackage("..Service..")
                    .should().accessClassesThat().resideInAPackage("..WebService..");
    // El layer "service" no deberia tener acceso al layer "web service"(controller)

    @ArchTest
    public static final ArchRule repository_should_not_access_services =
            noClasses().that().resideInAPackage("..Repositories..")
                    .should().accessClassesThat().resideInAPackage("..Service..");

    @ArchTest
    public static final ArchRule services_should_only_be_accessed_by_controllers_or_others_services =
            classes().that().resideInAPackage("..Service..")
                    .should().onlyBeAccessed().byAnyPackage("..WebService..","..Service..");

    @ArchTest
    public static final ArchRule services_should_not_depend_on_controllers =
            noClasses().that().resideInAPackage("..Service..")
                    .should().dependOnClassesThat().resideInAPackage("..WebService..");

    @ArchTest
    public static final ArchRule repository_should_not_depend_on_services =
            noClasses().that().resideInAPackage("..Repositories..")
                    .should().dependOnClassesThat().resideInAPackage("..Service..");

    @ArchTest
    public static final ArchRule services_should_only_be_depended_on_by_controllers_or_other_services =
            classes().that().resideInAPackage("..Service..")
                    .should().onlyHaveDependentClassesThat().resideInAnyPackage("..WebService..", "..Service..");

}
