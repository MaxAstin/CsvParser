<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <h1>Forms</h1>
        <ol>
            <#assign prev = "">
            <#list forms as form>
                <li> ${form[0]} </li>
                <#--<#if prev == formOld.ssoId>
                    <li>${formOld.formId!"formId"}</li>
                <#else>
                    <#if prev != "">
                        </ul> <br>
                    </#if>
                    <li>${formOld.ssoId!"ssoId"}</li>
                    <ul>
                        <li>${formOld.formId!"formId"}</li>
                    <#assign prev = formOld.ssoId>
                </#if>-->
            </#list>
            </ul>
        </ol>
    </body>
</html>