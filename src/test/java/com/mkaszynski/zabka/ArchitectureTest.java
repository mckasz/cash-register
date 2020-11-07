package com.mkaszynski.zabka;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;


@AnalyzeClasses(packages = "com.mkaszynski.zabka")
class ArchitectureTest {

    @ArchTest
    static final ArchRule payment_should_not_access_cashregistry =
        noClasses().that().resideInAPackage("..payment..")
                   .should().accessClassesThat().resideInAPackage("..cashregistry..");

    @ArchTest
    static final ArchRule domain_should_not_access_db =
        noClasses().that().resideInAPackage("..domain..")
                   .should().accessClassesThat().resideInAnyPackage("..db..");

    @ArchTest
    static final ArchRule dto_should_not_access_db_or_domain =
        noClasses().that().resideInAPackage("..dto..")
                   .should().accessClassesThat().resideInAnyPackage("..db..", "..domain..");
}
