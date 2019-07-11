<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <h1>Top</h1>
        <ol>
            <#list top as topLine>
                <li> <b>${topLine.formId}</b> - ${topLine.count}</li>
            </#list>
            </ul>
        </ol>
    </body>
</html>