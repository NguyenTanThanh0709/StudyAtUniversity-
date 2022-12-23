<?php
class bill{
    public $id;
    public $total;
    public $count;
    public $date;

    public function __construct($id, $total, $count, $date) {
        $this->id = $id;
        $this->total = $total;
        $this->date = $date;
        $this->count = $count;
      }
}