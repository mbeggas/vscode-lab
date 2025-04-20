def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):  # only check up to √n
        if n % i == 0:
            return False
    return True
