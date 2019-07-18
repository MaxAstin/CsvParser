<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <a href="/main"><< Main page</a>
        <h1>Unfinished</h1>
        <ol>
            <#assign prevSsoId = "">
            <#assign prevFormId = "">
            <#assign prevSubType = "">
            <#assign needHeader = true>
            <#list forms as form>
                <#if prevSsoId != form.ssoId || prevFormId != form.formId>
                    <#if prevSsoId != "">
                        <#if prevSubType != "send" && prevSubType != "done">
                            <#if needHeader>
                                <li> ${prevSsoId}</li> <ul>
                                <#assign needHeader = false>
                            </#if>
                            <li> ${prevFormId} - ${prevSubType}</li>
                            <#if prevSsoId != form.ssoId>
                                </ul> <br>
                                <#assign needHeader = true>
                            </#if>
                        </#if>
                    </#if>
                    <#assign prevSsoId = form.ssoId>
                    <#assign prevFormId = form.formId>
                </#if>
                <#assign prevSubType = form.subType>
            </#list>
            </ul>
        </ol>
    </body>
</html>