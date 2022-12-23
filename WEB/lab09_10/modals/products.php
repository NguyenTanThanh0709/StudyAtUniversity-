<?php
class products{
    public $id;
    public $name;
    public $price;
    public $description;
    public $vote;
    public $image;
    public $type;

    public function __construct($id, $name, $price, $description, $vote, $image, $tpye) {
        $this->id = $id;
        $this->name = $name;
        $this->price = $price;
        $this->description = $description;
        $this->vote = $vote;
        $this->image = $image;
        $this->type = $tpye;
      }
}