
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
      basicAlert({ icon: 'error', text: xhr.responseJSON.message });
      checkbox.checked = !checkbox.checked;
    }
  });
}

// 커스텀 확장자 추가
function addCustom() {
  const input = $('#extInput');
  const ext = input.val().trim();

  if (ext.length > 20) {
    basicAlert({ icon: 'warning', text: '확장자는 최대 20자까지 가능합니다.' });
    input.focus();
    return;
  }

  if (ext.length === 0) {
    basicAlert({ icon: 'warning', text: '확장자를 입력해주세요.' });
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
      basicAlert({ icon: 'error', text: xhr.responseJSON.message });
    }
  });
}

// 길이 제한
let maxAlertShown = false;

function limitLength(e, input) {
  const isControlKey = [
    'Backspace', 'Delete', 'ArrowLeft', 'ArrowRight', 'Tab'
  ].includes(e.key);

  if (input.value.length >= 20 && !isControlKey) {
    if (!maxAlertShown) {
      basicAlert({ icon: 'warning', text: '확장자는 최대 20자까지 등록 가능합니다.' });
      maxAlertShown = true;
    }
    e.preventDefault();
  } else {
    maxAlertShown = false;
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
      basicAlert({ icon: 'error', text: xhr.responseJSON.message });
    }
  });
}


// 파일 업로드 테스트
function fileUpload(){
  const file = $('#fileInput')[0].files[0];

  if (!file) {
    basicAlert({ icon: 'warning', text: '파일을 선택해주세요.' });
    return;
  }

  const formData = new FormData();
  formData.append('file', file);

  $.ajax({
    url: '/api/extension/upload',
    type: 'POST',
    data: formData,
    processData: false,
    contentType: false,
    success: function () {
      basicAlert({ icon: 'success', text: '\'파일 업로드 가능한 파일입니다.\'' });
    },
    error: function (xhr) {
      basicAlert({ icon: 'error', text: xhr.responseJSON.message });
    }
  });
}
