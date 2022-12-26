<head>
  <meta charset="UTF-8">
  <meta name="description" content="Initial page">
  <meta name="author" content="Karina Pinchuk">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body style="background-color:rgb(182,207,236);">
  <header>
      <h1 style="text-align:center">Welcome to my website</h1>
  </header>

  <form action="${pageContext.request.contextPath}/app/login">
        <input type="submit" value="Go to login page">
  </form>
</body>