<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Spirit Control</title>
    @vite('resources/js/app.js')    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300..700&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Montserrat+Alternates:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Quicksand:wght@300..700&display=swap" rel="stylesheet">
</head>
<body>
    <header class="header">
        <a class="logo" href="#">LOGO</a>
        <nav class="nav">
            <a href="#" class="nav_link">инфо</a>
            <a href="#asmr" class="nav_link">асмр</a>
            <a href="#aboutus" class="nav_link">о нас</a>
            <a href="#" class="record_link">запись</a>
            <!--<a href="#" class="nav_link_login">вход</a>!-->
            <div class="account-dropdown">
                <input type="checkbox" id="account-toggle" class="dropdown-toggle">
                <label for="account-toggle" class="nav_link_login_pic">
                    <img src="https://s.iimg.su/s/30/kWYe93D8RxWXXkyIBq0ck3YpSB5anHFMdayY9D0R.png" width="46.5" height="43.7" alt="Аккаунт">
                </label>
                <div class="dropdown-menu">
                    <a href="#" class="dropdown-item">профиль</a>
                    <a href="#" class="dropdown-item">настройки</a>
                    <a href="#" class="dropdown-item">выйти</a>
                </div>
            </div>
        </nav>
    </header>
    @csrf
    <form method="POST" action="/api/register">
        <fieldset>
            <legend>Введите имя</legend>
            <input type="text" name="name">
        </fieldset>
        <fieldset>
            <legend>Выберите пол</legend>
            <select class="container_login_item" name="gender" id="age">
                <option value="">--</option>
                <option value="male">мужской</option>
                <option value="female">женский</option>
                <option value="female">другой</option>
                </select>
        </fieldset>
        <fieldset>
            <legend>Дата рождения</legend>
            <input type="date" name="date_of_birth">
        </fieldset>
        <fieldset>
            <legend>Введите почту</legend>
            <input type="email" name="email">
        </fieldset>
        <fieldset>
            <legend>Придумайте пароль</legend>
            <input type="password" name="password">
        </fieldset>
        <input type="submit" class="container_login_submit">
    </form>
    <footer class="footer">
        <div class="footer_content">
            <p class="copyright">© 2025 Spirit Control</p>
        </div>
    </footer>
</body>