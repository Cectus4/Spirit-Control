<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Cache;
use Hash;
use Http;
use Illuminate\Support\Facades\Redirect;
use Log;
class UserController extends Controller
{
    public function register(Request $request)
    {
        $data = $request->validate([
            'name' => 'bail|required|filled|max:127',
            'email' => 'bail|required|filled|email:rfc,dns|',
            'password' => 'bail|required|filled',
            'date_of_birth' => 'bail|required|filled',
            'gender' => 'bail|required|filled',
        ]);
        
        Log::info($data);
        $user = [
            'name' => $data['name'],
            'email' => $data['email'],
            'password' => Hash::make($data['password']),
            'date' => $data['date_of_birth'],
            'gender' => $data['date_of_birth'],
        ];


        Http::post('http://localhost:8080/api/v1/spirit/user/save', 
            [
                'username' => $user['name'],
                'email' => $user['email'],
                'password' => $user['password'],
                'dob' => $user['date'],
                'gender' => $user['gender']
            ]        
            );


        return Redirect::to('/');
    }
}
