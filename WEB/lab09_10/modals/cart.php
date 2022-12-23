<?php
class cart{
    public $image;
    public $id;
    public $name;
    public $count;
    public $price;

    public function __construct($id, $name, $price, $count, $image) {
        $this->id = $id;
        $this->name = $name;
        $this->price = $price;
        $this->count = $count;
        $this->image = $image;
      }
}