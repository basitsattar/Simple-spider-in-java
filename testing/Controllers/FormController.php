<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Requests;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Session;
class FormController extends Controller {
    
    public function firstForm(Request $request)
    {
        $name = $request->input('plugin_name');
        $plugin_uri =$request->input('plugin_uri');
        $version = $request->input('version');
        $author_name = $request->input('author_name');
        $author_uri = $request->input('author_uri');
        $license = $request->input('license');
        $license_uri = $request->input('license_uri');
        $description = $request->input('description');
        
        session(['plugin_name'=>$name,'plugin_uri'=>$plugin_uri,'version'=>$version,'author_name'=>$author_name,
                'author_uri'=>$author_uri,'license'=>$license,'license_uri'=>$license_uri,'description'=>$description]);
        return redirect('/plugin/builder/admin');
    }
    public function adminForm(Request $request){
        $form_xml = $request->input('form_xml');
        session::put('form_xml',$form_xml);
        $data =array("success"=>true);
        return $data;
    }
    public function getAdminBuilder(){
        return view('widget.admin');
    }
     public function getFunctionsBuilder(){
        return var_dump(Session::all());
        return view('widget.functions');
    }
}
