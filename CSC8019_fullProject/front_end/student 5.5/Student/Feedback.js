
fetch('http://localhost:8080', { // Get feedback
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
})
.then(response => {
    if (!response.ok) {
        alert('Cannot get the data')
        throw new Error('fail to connect');
    }
    return response.json();
})
.then(data => {
    document.getElementById('content').textContent = data.feedback;
})
.catch(error => {
    console.error('wrong message:', error);
});

