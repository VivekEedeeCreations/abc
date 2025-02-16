<!DOCTYPE html>
<html>
<head>
    <title>File Upload Form</title>
</head>
<body>
    <h2>Upload File</h2>
    <form action="insertblob" method="post" enctype="multipart/form-data">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required><br><br>
        
        <label for="file">Select File:</label>
        <input type="file" name="file" id="file" required><br><br>
        
        <input type="submit" value="Upload">
    </form>
</body>
</html>
