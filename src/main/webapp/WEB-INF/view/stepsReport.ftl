<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <h1>Unfinished</h1>
        <ol>
            <#assign prevSsoId = "">
            <#assign prevFormId = "">
            <#assign prevSubType = "">
            <#assign needHeader = true>
            <#list steps as step>
                <#if prevSsoId != step.formOld.ssoId || prevFormId != step.formOld.formId>
                    <#if prevSsoId != "">
                        <#if prevSubType != "send" && prevSubType != "done">
                            <#if needHeader>
                                <li> ${prevSsoId}</li> <ul>
                                <#assign needHeader = false>
                            </#if>
                            <li> ${prevFormId} - ${prevSubType}</li>
                            <#if prevSsoId != step.formOld.ssoId>
                                </ul> <br>
                                <#assign needHeader = true>
                            </#if>
                        </#if>
                    </#if>
                    <#assign prevSsoId = step.formOld.ssoId>
                    <#assign prevFormId = step.formOld.formId>
                </#if>
                <#assign prevSubType = step.subType>
            </#list>
            </ul>
        </ol>
    </body>
</html>