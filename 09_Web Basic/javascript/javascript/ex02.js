let func = () => {
    console.log('째깍')
}

let timerId = setInterval(func, 2000)

setTimeout(() => {
    clearInterval(timerId);
    console.log('정지');
}, 10000)