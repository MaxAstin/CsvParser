<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Main page</h1>

    <ul>
        <li> <a href="/report/forms?date=2017-07-11-11">Recent forms report</a> </li>
        <li> <a href="/report/unfinished">Unfinished forms report</a> </li>
        <li> <a href="/report/top">Top forms report</a> </li>
    </ul>

    <form method="POST" enctype="multipart/form-data" action="/upload">
        <b>File to upload:</b> <br/>
        <input type="file" name="file"><br/>
        <input type="submit" value="Parse CSV file">
    </form>
</body>
</html>