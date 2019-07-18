<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <a href="/main"><< Main page</a>
        <h1>Top</h1>
        <ol>
            <#list top as topLine>
                <li> <b>${topLine[0]}</b> - ${topLine[1]}</li>
            </#list>
            </ul>
        </ol>
    </body>
</html>