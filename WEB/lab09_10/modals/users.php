<?php
class users{
    public $username;
    public $name;
    public $email;
    public $password;

    public function __construct($username, $name, $email, $password) {
        $this->username = $username;
        $this->name = $name;
        $this->email = $email;
        $this->password = $password;
      }
}