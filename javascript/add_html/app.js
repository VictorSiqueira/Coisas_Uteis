jQuery(document).ready(function () {
    'use strict';
    var input = 1,
        button = ("<button class='add'>Add Field</button>");
    var blank_line = $('.input_line').clone();
    $('#add').click(function () {
       
        $('form').append(blank_line.clone())
        $('.input_line').last().before($(this));
    });
    
    $('form').on('click', '.remove', function () {
        $(this).parent().remove();
         $('.input_line').last().before($('#add'));
        input = input - 1;
    });
    
    $('form').on('click', '.duplicate', function () {
       $('form').append($(this).parent().clone());
          $('.input_line').last().before($('#add'));
        input = input + 1;
    });
});
