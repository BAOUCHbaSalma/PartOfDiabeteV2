function generatePDF() {
    const element = document.querySelector('.container');
    html2pdf().from(element).save();
}



