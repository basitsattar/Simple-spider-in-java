<?php

/*
|--------------------------------------------------------------------------
| Routes File
|--------------------------------------------------------------------------
|
| Here is where you will register all of the routes in an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

Route::get('/', function () {
    return view('welcome');
});
Route::get('/plugin/builder',function(){
    return view('widget.start');
});
Route::get('/plugin/builder/admin',array('as'=>'admin/builder','uses'=>'FormController@getAdminBuilder'));
Route::get('/plugin/builder/functions','FormController@getFunctionsBuilder');

Route::post('/plugin/start','FormController@firstForm');
Route::post('/plugin/builder/admin','FormController@adminForm');
/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| This route group applies the "web" middleware group to every route
| it contains. The "web" middleware group is defined in your HTTP
| kernel and includes session state, CSRF protection, and more.
|
*/

Route::group(['middleware' => ['web']], function () {
    //
});
