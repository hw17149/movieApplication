<head>
  <style>
.floating-box {
    display: inline-block;
    width: 300px;
    height: 150px;
    margin: 10px;
    border-style: groove;
}


table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 70%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 5px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

td:first-child{
  width: 5%;
}
</style>
  
  <!--  Meta  -->
  <meta charset="UTF-8" />
  <title>admin</title>
  
  <!-- Menu Bar -->
  <ul>
  <li><a href="index.html">Home</a></li>
  <li><a href="">Current Showings</a></li>
  <li><a href="">Contact</a></li>
  <li><a href="search.html">Search</a></li>
  <li style="float:right"><a class="active" href="">About</a></li>
  <li style="float:right"><a class="active" href="login.html">Login/Signup</a></li>
  <li style="float:right"><a class="active" href="admin.html">Admin</a></li>
  
  </ul>
  
  <!--  Styles  -->
  <link rel="stylesheet" href="styles/index.processed.css">
</head>

<form class="admin">
  </head>
<body>

<h2>Theater List</h2>
<button type="button">Edit</button>
<button type="button">Add</button>
<table>
  <tr>
    <th>ID</th>
    <th>Theater</th>
    <th>Location</th>
    <th></th>
  </tr>
  <tr>
    <td>0</td>
    <td>Theater 1</td>
    <td>Location 1</td>
    <td><a href="">Listings</a></td>
  </tr>
  <tr>
    <td>1</td>
    <td>Theater 2</td>
    <td>Location 2</td>
    <td><a href="">Listings</a></td>
  </tr>
  <tr>
    <td>2</td>
    <td>Theater 3</td>
    <td>Location 3</td>
    <td><a href="">Listings</a></td>
  </tr>
  <tr>
    <td>3</td>
    <td>Theater 4</td>
    <td>Location 4</td>
    <td><a href="">Listings</a></td>
  </tr>
</table>

<p></p>
<h2>User List</h2>
<button type="button">Edit</button>
<button type="button">Add</button>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Birthday</th>
  </tr>
  <tr>
    <td>0</td>
    <td>Name 0</td>
    <td>email0@email.com</td>
    <td>Address0</td>
    <td>Birthday0</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Name 1</td>
    <td>email1@email.com</td>
    <td>Address1</td>
    <td>Birthday1</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Name 2</td>
    <td>email2@email.com</td>
    <td>Address2</td>
    <td>Birthday2</td>
  </tr>
  <tr>
    <td>3</td>
    <td>Name 3</td>
    <td>email3@email.com</td>
    <td>Address3</td>
    <td>Birthday3</td>
  </tr>
  <tr>
    <td>4</td>
    <td>Name 4</td>
    <td>email4@email.com</td>
    <td>Address4</td>
    <td>Birthday4</td>
  </tr>
</table>

<p></p>
<div class="floating-box">
  <p>Add promotion</p>
  Code: <input type="text" name="promo-code">
  <p>Percentage: <input type="text" name="amount-off"></p>
  <p><button>Add</button>
</div>


</body>
</html>

</form>