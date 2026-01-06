
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

// 커스텀 확장자 추가
function addCustom() {
  const input = $('#extInput');
  const ext = input.val().trim();

  if (!isValidLength(ext)) {
    alert('최대 입력 길이는 20자리입니다.');
    input.focus();
    return;
  }

  if (ext.length === 0) {
    alert('확장자를 입력해주세요.');
    input.focus();
    return;
  }

  $.ajax({
    url: '/api/extension/add',
    type: 'POST',
    data: { extension: ext },
    success: function() {
      location.reload();
    },
    error: function(xhr) {
      alert(xhr.responseJSON.message);
    }
  });
}

// 길이 제한
function isValidLength(value) {
  return value.length <= 20;
}


function checkLength(input) {
  if (!isValidLength(input.value)) {
    alert('최대 입력 길이는 20자리입니다.');
    input.value = input.value.substring(0, 20);
  }
}


// 커스텀 확장자 삭제
function deleteCustom(id){

  $.ajax({
    url: '/api/extension/delete',
    type: 'Delete',
    data: { id },
    success: function() {
      location.reload();
    },
    error: function(xhr) {
      alert(xhr.responseJSON.message);
    }
  });
}