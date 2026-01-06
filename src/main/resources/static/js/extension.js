
// 고정 확장자 체크박스
function toggleFixed(checkbox) {
  $.ajax({
    url: '/api/extension/checked',
    type: 'POST',
    data: {
      id: $(checkbox).data('id'),
      blocked: checkbox.checked
    },
    error: function(xhr) {
      alert(xhr.responseJSON.message);
      checkbox.checked = !checkbox.checked;
    }
  });
}