package apiTests

import io.qameta.allure.Feature

@Feature("Crud")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Crud

@Feature("AllUsers")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class AllUsers