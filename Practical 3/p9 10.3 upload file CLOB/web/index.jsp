<!DOCTYPE html>
<html>
<head>
    <title>Upload Text File</title>
</head>
<body>
    <h1>Samruddhi Surve 5358</h1>
    <h2>Upload a Text File</h2>
    <form action="Clobinsert" method="post" enctype="multipart/form-data">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required><br><br>
        
        <label for="file">Select File:</label>
        <input type="file" name="file" id="file" accept=".txt,.csv,.xml,.json" required><br><br>
        
        <input type="submit" value="Upload">
    </form>
</body>
</html>
