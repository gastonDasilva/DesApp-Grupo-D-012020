package com.tngtech.archunit.ComprandoEnCasa;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.ComprandoEnCasa.ComprandoEnCasaBackEnd")
public class LayeredArchitectureTest {

    @ArchTest
    public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .layer("Controllers").definedBy("com.ComprandoEnCasa.ComprandoEnCasaBackEnd.WebService..")
            .layer("Services").definedBy("com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service..")
            .layer("Repository").definedBy("com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories..")

            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Services");
}
