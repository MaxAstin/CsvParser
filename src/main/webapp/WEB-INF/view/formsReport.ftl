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