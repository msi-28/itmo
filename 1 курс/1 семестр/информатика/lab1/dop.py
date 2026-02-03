# перевод из фибоначчиевой системы счисления в десятиричную

# создадим последовательность фибоначчи необходимого размера с помощью рукописной функции
def make_fib(num_fib, fib_arr):
    for i in range(len(num_fib)):
        fib_arr.append(fib_arr[i] + fib_arr[i-1])
    return fib_arr

num_fib = input("Число в фибоначчиевой системе счисления: ").strip()[::-1] # получаем число в фсс
num_10 = 0 # переменная для числа в 10-ой системе счисления
fibonacci_sequence = make_fib(num_fib, [1]) # массив с последовательностью фибоначчи

for i in range(0, len(num_fib)):
    fib_element = fibonacci_sequence[i] # элемент из последовательности фибоначчи с индексом i
    index = int(num_fib[i]) # цифра из числа в фсс с индексом i
    num_10 += fib_element**index*index
print(num_10)