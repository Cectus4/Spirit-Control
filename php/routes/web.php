<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});
Route::get('/register', function () {
    return view('register');
});
Route::get('/profile', function() {
    return view('profile');
});

Route::get('/login', function() {
    return view('login');
});

Route::get('/record', function() {
    return view('record');
});

