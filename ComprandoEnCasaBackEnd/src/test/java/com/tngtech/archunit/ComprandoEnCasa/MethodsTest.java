package com.tngtech.archunit.ComprandoEnCasa;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noCodeUnits;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.ComprandoEnCasa.ComprandoEnCasaBackEnd")
public class MethodsTest {

    @ArchTest
    static ArchRule code_units_in_service_layer_should_be_autowired =
            noCodeUnits()
                    .that().areDeclaredInClassesThat().resideInAPackage("..Service..")
                    .should().beMetaAnnotatedWith(Autowired.class);
}
