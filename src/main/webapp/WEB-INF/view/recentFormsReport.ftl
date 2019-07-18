<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <a href="/main"><< Main page</a>
        <h1>Forms</h1>
        <ol>
            <#assign prev = "">
            <#list forms as form>
               <#-- <li> ${form[0]} </li>-->
                <#if prev == form.ssoId>
                    <li>${form.formId!"formId"}</li>
                <#else>
                    <#if prev != "">
                        </ul> <br>
                    </#if>
                    <li>${form.ssoId!"ssoId"}</li>
                    <ul>
                        <li>${form.formId!"formId"}</li>
                    <#assign prev = form.ssoId>
                </#if>
            </#list>
            </ul>
        </ol>
    </body>
</html>