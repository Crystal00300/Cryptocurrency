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
	
	
	
//.toLocaleString =>千分位 
//undefined, {maximumFractionDigits: 0} =>最大小數位0 設1則顯示小數點後1位
//如果用 (td.toFixed(0)).toLocaleString(); 會失敗 只會顯示無小數點 但不會千分位

$('.vol24h,.market').each(function(i, el) {
	var td = parseFloat($(el).text());
	if (!isNaN(td)) {
	$(el).text('$' + td.toLocaleString(undefined, {maximumFractionDigits: 0}));
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

$('.price,.price1').each(function(i,el){
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


//$(function() {
//  $('.price').each( function() {
//    var elem = $(this) ,
//        value = parseFloat( elem.text() );
//    if( value < $('.price1').text() ) {
//      elem.css('color', 'red');
//    }
//    if( value > $('.price1').text() ) {
//      elem.css('color', 'green');
//    }
//  });
//});




//只顯示幾位數

//$('.vol24h,.market').each(function(i,el){
//   var td = parseFloat($(el).text());
//   if(!isNaN(td)){
//      $(el).text('$'+td.toPrecision(11));
//   }
//});	