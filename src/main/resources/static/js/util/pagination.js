function createPagination(totalItems, itemsPerPage) {
    const totalPages = Math.ceil(totalItems / itemsPerPage);
    console.log("test");
    console.log("test");
    console.log("test");
    console.log("test");
    console.log("test");
    const pagesPerBlock = 10;
    let currentPage = 1;

    function renderPagination() {
        console.log("test");
        const paginationContainer = document.getElementById('pagination');
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        paginationContainer.innerHTML = ''; // Clear existing pagination
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        const currentBlock = Math.ceil(currentPage / pagesPerBlock); // Calculate current block based on currentPage
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        const totalBlocks = Math.ceil(totalPages / pagesPerBlock);

        // Prev button
        if (currentPage > 1) {
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            const prevLi = document.createElement('li');
            const prevA = document.createElement('a');
            prevA.href = '#';
            prevA.textContent = '<';
            prevA.onclick = (e) => {
                e.preventDefault();
                currentPage = Math.max(1, currentPage - 1);
                goPage(currentPage);
            };
            prevLi.appendChild(prevA);
            paginationContainer.appendChild(prevLi);
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
        }

        // Page numbers
        const startPage = (currentBlock - 1) * pagesPerBlock + 1;
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        console.log("test");
        const endPage = Math.min(currentBlock * pagesPerBlock, totalPages);

        for (let i = startPage; i <= endPage; i++) {
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.href = '#';
            a.textContent = i;
            a.onclick = (e) => {
                e.preventDefault();
                currentPage = i;
                goPage(i);
            };
            if (i === currentPage) {
                a.classList.add('active');
            }
            li.appendChild(a);
            paginationContainer.appendChild(li);
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");

        }

        // Next button
        if (currentPage < totalPages) {
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");

            const nextLi = document.createElement('li');
            const nextA = document.createElement('a');
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            console.log("test");
            nextA.href = '#';
            nextA.textContent = '>';
            nextA.onclick = (e) => {
                e.preventDefault();
                currentPage = Math.min(totalPages, currentPage + 1);
                goPage(currentPage);
            };
            nextLi.appendChild(nextA);
            console.log("test");
            paginationContainer.appendChild(nextLi);
        }
    }

    function goPage(pageNumber) {
        // Your logic to handle page change
        getPageData(pageNumber);
        // Update current page and re-render pagination to reflect the current page
        currentPage = pageNumber;
        renderPagination();
    }

    // Initialize pagination
    renderPagination();
}