<?php
class category{
    public $id;
    public $name;
    public $note;

    public function __construct($id, $name, $note) {
        $this->id = $id;
        $this->name = $name;
        $this->note = $note;
      }
}