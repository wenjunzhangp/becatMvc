/*
**index customer-logo hover
 */

// $(".coustomer-logo").find(".am-u-md-2 a").each(function() {
//   $(this).hover(function() {
//     console.log(1)
//       $(this).find(".am-active").show();
//       $(this).find(".normal-logo").hide();
//   }, function() {
//     $(this).find(".am-active").hide();
//     $(this).find(".normal-logo").show();
//   });
// });
(function(){
  $('.customer-logo').find('.customer-box').each(function(){
    $(this).hover(function(){
        $(this).find('.am-active').show();
        $(this).find('.normal-logo').hide();
    },function(){
        $(this).find('.am-active').hide();
        $(this).find('.normal-logo').show();
    })
  });
})()
