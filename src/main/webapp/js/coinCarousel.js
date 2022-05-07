$(".responsive").slick({
	  dots: true,
	  infinite: false,
	  speed: 300,
	  slidesToShow: 4,
	  slidesToScroll: 4,
	  responsive: [
	    {
	      breakpoint: 1024,
	      settings: {
	        slidesToShow: 3,
	        slidesToScroll: 3,
	        infinite: true,
	        dots: true
	      }
	    },
	    {
	      breakpoint: 600,
	      settings: {
	        slidesToShow: 2,
	        slidesToScroll: 2
	      }
	    },
	    {
	      breakpoint: 480,
	      settings: {
	        slidesToShow: 1,
	        slidesToScroll: 1
	      }
	    }
	  ]
	});
	
	
	
//千分位

$('.vol24h,.market').each(function(i, el) {
	var td = parseFloat($(el).text());
	if (!isNaN(td)) {
	$(el).text('$' + td.toLocaleString());
	}
});	


//取小數後2位+百分比


$('.1h,.24h,.7d,.30d').each(function(i,el){
   var td = parseFloat($(el).text());
   if(!isNaN(td)){
      $(el).text(td.toFixed(2) + '%');
   }
});	

//取小數後兩位 + 錢字號

$('.price').each(function(i,el){
   var td = parseFloat($(el).text());
   if(!isNaN(td)){
      $(el).text('$' + td.toFixed(2));
   }
});	


//判斷大於0顯綠 反之顯紅


$(function() {
  $('.1h,.24h,.7d,.30d').each( function() {
    var elem = $(this) ,
        value = parseFloat( elem.text() );
    if( value < 0 ) {
      elem.css('color', 'red');
    }
    if( value > 0 ) {
      elem.css('color', 'green');
    }
  });
});




//$('.vol24h,.market').each(function(i,el){
//   var td = parseFloat($(el).text());
//   if(!isNaN(td)){
//      $(el).text('$'+td.toPrecision(11));
//   }
//});	