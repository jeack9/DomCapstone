function UnityProgress(unityInstance, progress) {
// 현재 URL의 쿼리 문자열을 가져옵니다.
var queryString = window.location.search;

// 쿼리 문자열을 파싱하여 인자값을 추출합니다.
var urlParams = new URLSearchParams(queryString);

// 특정 인자값을 가져옵니다.
var value = urlParams.get('place');
var value2 = urlParams.get('kor');
  if (!unityInstance.Module) return;
  if (!unityInstance.logo) {
    unityInstance.logo = document.createElement("div");
    unityInstance.logo.className =
      "logo " + unityInstance.Module.splashScreenStyle;
    unityInstance.container.appendChild(unityInstance.logo);
  }
  if (!unityInstance.progress) {
    unityInstance.progress = document.createElement("div");
    unityInstance.progress.className =
      "progress " + unityInstance.Module.splashScreenStyle;
    unityInstance.progress.empty = document.createElement("div");
    unityInstance.progress.empty.className = "empty";
    unityInstance.progress.appendChild(unityInstance.progress.empty);
    unityInstance.progress.full = document.createElement("div");
    unityInstance.progress.full.className = "full";
    unityInstance.progress.appendChild(unityInstance.progress.full);
    unityInstance.container.appendChild(unityInstance.progress);
  }
  unityInstance.progress.full.style.width = 100 * progress + "%";
  unityInstance.progress.empty.style.width = 100 * (1 - progress) + "%";
  if (progress == 1) {
    unityInstance.logo.style.display = unityInstance.progress.style.display =
      "none";

    setTimeout(() => {
        if(value != null){
            goStraight(value, value2);
        }else{
            showTitle();
        }

    }, 2500);
  }
}