def is_prime(n):
    if n < 2:
        return False
    for i in range(2, n):  # تم تعديل نطاق الحلقة إلى 2 حتى n (غير شامل)
        if n % i == 0:
            return False
    return True
