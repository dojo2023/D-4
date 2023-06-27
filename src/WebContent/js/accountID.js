window.addEventListener('DOMContentLoaded', (event) => {
      // ページ読み込み時にポップアップを表示
      const popup = document.querySelector('.popup');
      popup.classList.add('show');
    });

    const popup = document.querySelector('.popup');
  	const closeBtn = document.querySelector('.close-btn');
  	closeBtn.addEventListener('click', () => {
    popup.style.display = 'none'; // ポップアップを非表示にする
  });