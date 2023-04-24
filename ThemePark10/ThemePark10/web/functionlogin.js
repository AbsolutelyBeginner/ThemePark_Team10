function checkValidation()
{
    var isAdmin = document.getElementById("name").value;
    var password = document.getElementById("password").value;
    var manager1 = document.getElementById("name").value;
    var password1 = document.getElementById("password").value;
    if ( isAdmin == "admin" && password == "123")
    {
        alert ("Redirecting to Admin Page");
        //window.location = "C:/Users/huybu/OneDrive/Documents/Spring 2023/COSC 3380/DBMS Project/ThemePark_Team10/Login_pages";
        window.location = "adminpage.html";
        return false;
    }
    else
    if( manager1 = "JoeBiden69" && password1 == "456")
    {
        alert ("Redirecting to Management Page");
        //window.location = "C:/Users/huybu/OneDrive/Documents/Spring 2023/COSC 3380/DBMS Project/ThemePark_Team10/Login_pages";
        window.location = "ManagerDashboard.html";
        return false;
    }
    else
    {
        alert('Wrong Password!');
        return false;
    }
    
    
}
function checkRegistration()
{
    
}